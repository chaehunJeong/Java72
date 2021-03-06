var express = require('express');
var bodyParser = require('body-parser');

var app = express();

app.use(bodyParser.json());
app.use(bodyParser.urlencoded({
  extended: true
}));

// 정적 자원(HTML, CSS, JavaScript, Images, ...)을 
// 처리하는 도구 등록
app.use(express.static('www'));

var board = require('./routes/board');
app.use('/board', board);

var member = require('./routes/member');
app.use('/member', member);

var files = require('./routes/files');
app.use('/files', files);

app.get('/', function (req, res) {
  res.send('Hello World!');
});

var server = app.listen(8888, function () {
  var host = server.address().address;
  var port = server.address().port;

  console.log('서버 실행 중: http://%s:%s', host, port);
});




