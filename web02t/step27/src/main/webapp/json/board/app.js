var currPageNo = 1;
var pageSize = 3;

$('.my-view').css('display', 'none');
$('.my-new').css('display', '');

listBoard(currPageNo, pageSize);

var prevBtn = $('#prevBtn');
prevBtn.click(function(event) {
  event.preventDefault();
  if ($(this).attr('disabled') == 'disabled') {
    return;
  }

  //이전 페이지 목록 가져오기
  listBoard(currPageNo - 1, pageSize);
});

var nextBtn = $('#nextBtn');
nextBtn.click(function(event) {
  event.preventDefault();
  if ($(this).attr('disabled') == 'disabled') {
    return;
  }
  //다음 페이지 목록 가져오기
  listBoard(currPageNo + 1, pageSize);
});

var deleteBtn = $('#deleteBtn');
deleteBtn.click(function(event) {
  event.preventDefault();
  deleteBoard($('#fNo').val());
});

var updateBtn = $('#updateBtn');
updateBtn.click(function(event) {
  event.preventDefault();
  updateBoard();
});

var insertBtn = $('#insertBtn');
insertBtn.click(function(event) {
  event.preventDefault();
  insertBoard();
});

var cancelBtn = $('#cancelBtn');
cancelBtn.click(function(event) {
  $('.my-view').css('display', 'none');
  $('.my-new').css('display', '');
});

function listBoard(pageNo, pageSize) {
  $.getJSON('list.do', 
    {
      pageNo: pageNo,
      pageSize: pageSize,
    }, 
    function(result) {
      window.currPageNo = result.pageNo;
      $('#pageNo').text(currPageNo);
      
      var tbody = $('#listTable tbody');
      $('.data-row').remove();
      
      var tr;
      var obj = result.data;
      for (var i in obj) {
        tr = $('<tr>').addClass('data-row').appendTo(tbody);
        $('<td>').text(obj[i].no).appendTo(tr);
        $('<td>').append($('<a>')
                    .addClass('titleLink')
                    .attr('bno', obj[i].no)
                    .attr('href', '#')
                    .text(obj[i].title))
                 .appendTo(tr);
        $('<td>').text(obj[i].yyyyMMdd).appendTo(tr);
        $('<td>').text(obj[i].viewCount).appendTo(tr);
      }
      
      // 이전, 다음 버튼 처리
      if (result.pageNo > 1) {
        prevBtn.removeAttr('disabled');
        prevBtn.attr('href', 'list.do?pageNo=' 
          + (result.pageNo - 1) 
          + '&pageSize=' + result.pageSize); 
      } else {
        prevBtn.attr('disabled', 'disabled');
      }
      
      if (result.isNextPage) {
        nextBtn.removeAttr('disabled');
        nextBtn.attr('href', 'list.do?pageNo=' 
          + (result.pageNo + 1) 
          + '&pageSize=' + result.pageSize);
      } else {
        nextBtn.attr('disabled', 'disabled');
      }
      
      $('.titleLink').click(function(event){
        event.preventDefault();
        detailBoard(this.getAttribute('bno'));
        $('.my-view').css('display', '');
        $('.my-new').css('display', 'none');
      });
  });
}

function detailBoard(no) {
  $.getJSON('detail.do?no=' + no, function(result) {
    var data = result.data;
    $('#fNo').val(data.no);
    $('#fTitle').val(data.title);
    $('#fContent').val(data.content);
    $('#fCreateDate').text(data.yyyyMMdd);
    $('#fViewCount').text(data.viewCount);
    $('#fAttachFile')
      .text(data.attachFile1)
      .attr('href', '../../files/' + data.attachFile1);
  });
}

function deleteBoard(no) {
  $.getJSON('delete.do?no=' + no, function(result) {
    if (result.data == 'success') {
      alert('삭제 성공입니다.');
      listBoard(currPageNo, pageSize);
      $('#cancelBtn').click();
    } else {
      alert('삭제할 수 없습니다.');
    }
  });
}

function updateBoard() {
  $.ajax('update.do',
    {
      method: 'POST',
      dataType: 'json',
      data: {
        no: $('#fNo').val(),
        title: $('#fTitle').val(),
        content: $('#fContent').val()
      },
      success: function(result) {
        if (result.data == 'success') {
          alert('변경 성공입니다.');
          listBoard(currPageNo, pageSize);
          $('#cancelBtn').click();
        } else {
          alert('변경할 수 없습니다.');
        }
      }
    });
}

function insertBoard() {
  $.ajax('insert.do',
    {
      method: 'POST',
      dataType: 'json',
      data: {
        title: $('#fTitle').val(),
        content: $('#fContent').val(),
        password: $('#fPassword').val()
      },
      success: function(result) {
        if (result.data == 'success') {
          alert('입력 성공입니다.');
          listBoard(1, pageSize);
          $('#cancelBtn').click();
        } else {
          alert('입력할 수 없습니다.');
        }
      }
    });
}


  
  
  
  
  
  
  
  
  
  
  
  
  
  
  
  




