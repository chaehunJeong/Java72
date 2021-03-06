[step01]
Test01.java
  - 빈(객체)를 생성하는 예전 방식: new 사용
  - 빈을 찾지 못했을 때 예외 발생!

Test02.java
  - 스프링에서 빈(Bean=instance=object=component) 생성을 설정하는 방법
    <bean id="객체이름" 
          class="전체클래스명(패키지명+클래스명)"/>
  - 스프링 빈 컨테이너에서 객체 꺼내기
    ctx.getBean("객체이름")
    => 만약 해당 이름을 가진 객체를 찾지 못한다면, 예외 발생!

Test03.java
  - id 대신 name 속성을 사용하여 빈의 이름을 설정하기
  - id가 없으면 name 속성의 값을 빈의 이름으로 사용한다.\
  <bean name="c1" class="step01.Car"/>
  
  - 빈의 이름을 여러 개 지정하기
    => name 속성의 첫 번째 이름은 빈의 아이디로 사용하고,
       나머지 이름은 빈의 별명으로 등록한다.
    => 중요한 것은 아이디나 별명의 차이점이 없다.
       즉 getBean("아이디 또는 별명")
      <bean name="c2 c3 c4" class="step01.Car"/>
    
    => 공백 대신 콤마(,) 또는 세미콜론(;) 가능하다.
    => name이나 id 속성에 특수 문자를 넣을 수 있다.
      <bean name="okok^^" class="step01.Car"/>
      <bean id="nono^^" class="step01.Car"/>
    
    => id 속성은 공백이나 콤마, 세미콜론을 사용하여 
       이름을 여러 개 지정할 수 없다.
       즉 id는 오직 하나의 이름만 지정 가능하다.
       <bean id="k1 k2 k3" class="step01.Car"/>
       
       위의 선언은 객체의 이름이 "k1 k2 k3"이다.
       "k1", "k2", "k3"가 아니다!  
       
Test04.java
  - 이름을 지정하지 않을 때?
    => 빈의 이름을 지정하지 않으면 클래스 전체 이름을 사용한다.
    => 같은 클래스일 경우, 
       첫 번째 객체는 "전체클래스명", "전체클래스명#0"
       두 번째 부터는 "전체클래스명#n" (n > 0)

Test05.java
  - 생성자 호출하는 방법
  <bean id="c14" class="step01.Car">
    <constructor-arg type="java.lang.String" 
        value="티코" index="0"/>
    <constructor-arg type="int" value="900" index="1"/>
  </bean>
  
Test06.java
  - 셋터 호출하는 방법
  <bean id="c2" class="step01.Car">
    <property name="model" value="소나타"/>
    <property name="cc" value="1998"/>
  </bean>
  
Test07.java
  - <bean>의 속성을 이용하여 생성자 및 셋터 호출하기
  1) <beans> 태그에 다음 네임스페이스를 추가한다.
     => XML 스키마 위치 정보는 추가할 필요 없다.
  <beans ...
    xmlns:c="http://www.springframework.org/schema/c"
    xmlns:p="http://www.springframework.org/schema/p"
    ...>

Test08.java
  - 의존 객체 주입하기
  - Engine 클래스 작성
  - Car 클래스에 Engine 프로퍼티 추가    

Test09.java
  - 컬렉션 타입(배열이나 Collection 구현체) 중 배열 타입의 
    프로퍼티 값 설정하기

Test10.java
  - 컬렉션 타입 중 List 타입의 프로퍼티 값 설정하기

Test11.java
  - 컬렉션 타입 중 Set 타입의 프로퍼티 값 설정하기

Test12.java
  - 맵 타입 프로퍼티 값 설정하기 

Test13.java
  - 스태틱 팩토리 메서드 호출하여 객체 생성하기
    => CarFactory 클래스 작성
    => makeCar() 호출하기
    
Test14.java
  - 인스턴스 팩토리 메서드 호출하여 객체 생성하기
    => CarFactory2 클래스 작성
    => makeCar() 호출하기

Test15.java
  - 스프링 프레임워크의 규칙(FactoryBean)에 따라 만든 
    팩토리 클래스를 사용하여 객체를 생성한다.
  - 스프링 프레임워크는 객체를 생성하려 할 때
    클래스의 타입을 검사한다.
    만약 클래스가 FactoryBean 구현체라면,
    FactoryBean 객체를 저장하는 것이 아니라
    FactoryBean의 getObject()가 리턴한 값을 저장한다.

Test16.java
  - 빈의 생성 정책
    => singleton : 오직 한 개만. (기본)
                   getBean()이 리턴하는 객체가 동일하다. 
    => prototype : 매번 생성.
                   getBean()이 리턴하는 객체는 다르다.
                   getBean()을 호출할 때 매번 생성한다.

Test17.java
  - 날짜 속성의 값 설정하기
  - 문자열을 java.util.Date 객체로 만들어주는 
    SimpleDateFormat 클래스를 사용한다. 

Test18.java
  - 커스텀 프로퍼티 에디터를 만들어 스프링에 등록한다.
  - 커스텀 프로퍼티 에디터?
    문자열을 특정 타입의 객체로 만들어주는 도구다.
  - 커스텀 프로퍼티 에디터를 설정했을 때 이점?
    => 그냥 문자열로 값을 넣으면 자동으로 원하는 타입의
       객체로 만들어주기 때문에 코딩이 편하다. 
  - 방법
  1) 프로퍼티 에디터 등록기를 만든다
    => MyCustomPropertyEditorRegistrar 클래스 작성
  2) 스프링에 프로퍼티 에디터 등록기를 추가한다.
    => 스프링 설정 파일에 다음 설정 추가
    <bean class="org.springframework.beans.factory.config.CustomEditorConfigurer">
      <property name="propertyEditorRegistrars">
        <list>
          <bean class="step04.MyCustomPropertyEditorRegistrar"/>
        </list>
      </property>
    </bean>
  
Test19.java
  - 직접 커스텀 프로퍼티 에디터 등록하기
  - 방법
  1) 날짜 커스텀 프로퍼티 에디터 생성한다.
     => MyCustomDateEditor 클래스 작성
  2) 스프링 설정 파일에 등록한다.
  <bean class="org.springframework.beans.factory.config.CustomEditorConfigurer">
    <property name="customEditors">
      <map>
        <entry key="java.util.Date" 
               value="step04.MyCustomDateEditor"/>
      </map>
    </property>
  </bean>
    
Test20.java
  - Engine 타입의 프로퍼티 값을 문자열로 등록하기.
  - 방법
  1) 문자열을 Engine 타입의 객체로 바꿔주는 변환기를 만든다.
     => CustomEngineEditor 클래스 작성
  2) 스프링 설정 파일에 등록한다.
    <bean class="org.springframework.beans.factory.config.CustomEditorConfigurer">
        <property name="customEditors">
          <map>
            <entry key="java.util.Date" 
                   value="step04.MyCustomDateEditor"/>
            <entry key="step04.Engine" 
                   value="step04.MyCustomEngineEditor"/>       
          </map>
        </property>
    </bean>

Test21.java
  - 애노테이션을 이용하여 의존 객체를 자동 주입하기 
    => @Autowired를 setEngine()에 붙인다.
  - @Autowired 애노테이션이 동작하려면,
    이 애노테이션을 처리하는 객체를 스프링에 등록해야 한다.

Test22.java    
  - @Autowired는 셋터 메서드에 붙이지만,
    인스턴스 변수에 붙일 수도 있다.

Test23.java
  - @Autowired는 필수이다.
    => 만약 주입할 의존 객체를 못 찾으면 예외 발생한다.

Test24.java
  - 의존 객체 주입을 선택 사항으로 만들기
    => @Autowired(required=false)

Test25.java
  - 의존 객체 주입은 프로퍼티 타입을 기준으로 찾는다.
    따라서 같은 타입의 객체가 두 개 이상 있을 때 
    스프링이 당황하여 예외 발생시킨다.

Test26.java
  - 해결책: 주입할 객체 이름을 지정한다.
    => @Qualifier("객체이름") 
  - 단 이 애노테이션을 처리할 객체를 등록하라!
    매번 애노테이션을 사용할 때 마다 
    그 애노테이션을 처리할 BeanPostProcessor를 등록한다면,
    유지보수가 힘들어진다.
    => 한방에 등록하기
    => <context:annotation-config/>
    
Test27.java
  - 스프링 컨테이너가 관리하는 모든 객체를 뽑아보자!
  - 주의!
    스프링에 어떤 기능을 사용하고 싶다면,
    해당 기능을 처리하는 객체를 등록하라!

Test28.java
  - @Resource = @Autowired + @Qualifier
  
Test29.java
  - 빈 자동 생성 애노테이션
  - @Component : 자동으로 생성할 객체를 지정한다.
    => 클래스의 역할을 더 상세히 지정하는 방법
    => @Controller: 사용자와 상호작용하는 역할
    => @Service: 업무 관련 로직을 처리하는 역할
    => @Repository: 데이터 관련 로직을 처리하는 역할(DAO)
  - 이 애노테이션이 동작하려면,
    1) 애노테이션을 처리할 객체를 등록해야 한다.
        <context:annotation-config/>
    2) 애노테이션이 붙은 클래스를 찾아야 한다.
       => 이 태그를 선언하면 annotation-config 태그는
          선언할 필요가 없다. 자동으로 포함한다.
        <context:component-scan base-package="step06"/>
  - 애노테이션으로 빈을 생성할 때,
    빈의 이름을 주지 않으면 
    클래스 이름(첫 알파벳은 소문자)을 빈의 이름으로 사용한다.      








      