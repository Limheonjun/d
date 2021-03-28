# Junit5
springboot에 기본적으로 Junit5가 탑재



## Annotations

- @Test
	> 테스트 코드임을 알려주는 애노테이션
	> 접근지정자와 반환타입은 없어도 됨

- @BeforeAll
	> 모든 테스트 전에 딱 한번 실행
	> static void로 선언

- @AfterAll
	> 모든 테스트 후 딱 한번 실행
	> static void로 선언

- @BeforeEach
	> @Test가 붙은 코드를 실행하기 전 매번 실행
	> 접근지정자와 반환타입은 없어도 됨	
	
- @AfterEach
	> @Test가 붙은 코드를 실행한 후 매번 실행
	> 접근지정자와 반환타입은 없어도 됨	

- @Disabled
	> 해당 테스트는 무시하고 진행

- @DisplayName
	> 테스트 이름을 사용자가 정의할 수 있음
	> @DisplayName(사용자 정의)

## Assertion

- assertEquals(expected, actual)
	> 기대값과 실제값이 같은지 확인
		 
- assertNotNull(actual)
	> 값이 null이 아닌지 확인

- assertTrue(boolean)
	> 값이 true인지 확인

- assertAll(executables...)
	> 인자로 받은 테스트를 한꺼번에 확인

- assertThrows(expectedType, executable)
	> 예외 발생 확인

- assertTimeout(duration, executable)
	> 특정 시간 안에 실행이 완료되는지 확인

## Condition Test

- assumeTrue(조건)
	> 조건이 참인 경우에만 다음 코드 실행

- assertThat(조건, 테스트)
	> 조건이 참인 경우에만 테스트 실행
	
- @Enabled__, @Disabled__
    >*OS, Jre 등 해당 조건을 만족할때만 실행 또는 실행하지 않게 함*
    
	> OnOs
	> OnJre
	> IfSystemProperty
	> IfEnvironmentVariable
	> If

## Taging

- @Tag
	> 테스트 메소드에 태그를 추가할 수 있음
	> 태그로 필터링 가능
	> 하나의 테스트 메소드에 여러 태그 사용 가능

## Repeat

- @RepeatedTest
	> 랜덤값 등 반복적으로 테스트가 필요한 곳에 사용
	> placeholder를 사용할 수 있음
	>- {displayName}, {currentRepetition}, {totalRepetitions}

	> 반복 횟수와 반복 테스트 이름을 설정할 수 있음
	>- @RepeatedTest(value = 10, "{displayName}의 {currentRepetition}째 테스트")
	
	> 테스트 메소드의 인자로 RepetitionInfo를 받으면 몇번째 반복인지, 몇번째 반복해야하는지 등의 정보를 얻을 수 있음
	
- @ParameterizedTest
	> 테스트에 여러 다른 매개변수를 대입해가며 반복 실행
	
	> placeholder 사용 가능
	>- {displayName}, {index}, {arguments}, {0}, {1} ...

	*인자 값들의 소스*
	 > @ValueSource
	 > @NullSource, @EmptySource, @NullAndEmptySource
	 > @EnumSource
	 > @MethodSource
	 > @CvsSource
	 > @CvsFileSource
	 > @ArgumentSource
	> 
	
	*인자 값 타입 변환*
	> 암묵적인 타입 변환
	>> 레퍼런스 참고
	
	> 명시적인 타입 변환
	>> SimpleArgumentConverter 상속 받은 구현체 제공
	>> @ConvertWith
	
	*인자 값 조합*
	> ArgumentsAccessor
	> 커스텀 Accessor
	>> ArgumentsAggregator 인터페이스 구현
	>> @AggregateWith

## Test Instance
**JUnit은 테스트 메소드 마다 테스트 인스턴스를 새로 만든다.**
- 이것이 기본 전략.
- 테스트 메소드를 독립적으로 실행하여 예상치 못한 부작용을 방지하기 위함이다.
- 이 전략을 JUnit 5에서 변경할 수 있다.
- 테스트간의 의존성을 없애기 위해서

**@TestInstance(Lifecycle.PER_CLASS)**
- 테스트 클래스당 인스턴스를 하나만 만들어 사용한다.
- 경우에 따라, 테스트 간에 공유하는 모든 상태를 @BeforeEach 또는 @AfterEach에서
초기화 할 필요가 있다.
- @BeforeAll과 @AfterAll을 인스턴스 메소드 또는 인터페이스에 정의한 default 메소드로
정의할 수도 있다.