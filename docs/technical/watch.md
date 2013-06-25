지켜보기
--------

지켜보기 버튼을 누르면 해당 게시물을 지켜보게 된다. 해당 게시물에 댓글이 달린 경우 알려준다.

그만보기
--------

지켜보기 버튼이 눌려있는 상태에서 한번 더 누르면 지켜보기 버튼이 원래대로 돌아온다. 이 상태에서는 게시물에 댓글이 달려도 알림을 받지 않는다.

자동으로 지켜보기 상태가 되는 경우
----------------------------------

어떤 게시물 혹은 이슈에 대해,

* 해당 프로젝트를 지켜보는 사용자
* 저자
* 담당자
* 댓글을 단 사용자

단, 그 사용자가 눌려있는 지켜보기 버튼을 다시 눌러 명시적으로 지켜보기를 해제하였다면, 위의 조건에 해당하더라도 자동으로 지켜보기 상태가 되지 않는다.

내부 동작
---------

### 누군가 지켜보기 버튼을 눌렀을 때

* 누군가 지켜보기 버튼을 누른다면, 그 사용자를 '명시적으로 지켜보고 있는 사용자들의 목록'에 추가하고, '명시적으로 무시하고 있는 사용자들의 목록'에서 제거한다. 단, 읽기 권한이 없는 경우에는 403 Forbidden으로 응답한다.
* 누군가 지켜보기 버튼을 해제한다면, 그 사용자를 '명시적으로 지켜보고 있는 사용자들의 목록'에서 제거하고, '명시적으로 무시하고 있는 사용자들의 목록'에 추가한다. 게시물에 읽기 권한이 없더라도 가능하다.

### 특정 게시물을 지켜보고 사용자들의 목록 얻기

1. 특정 게시물에 댓글이 달렸을 때, 우선 다음 사용자들을 모두 합한 목록을 얻는다.
    * 게시물 저자
    * 이슈 담당자
	* 프로젝트를 지켜보는 사용자
    * 현재 게시물에 달려있는 댓글의 저자
    * 명시적으로 지켜보고 있는 사용자

2. 이 목록에서 다음에 해당하는 경우의 사용자들을 제거한다.
    * 현재 댓글을 단 사용자
    * 명시적으로 무시하고 있는 사용자
    * 이 게시물에 대해 읽기 권한이 없는 사용자

### 알림 발송

누군가 게시물에 댓글을 달았다면, 위의 방법으로 얻은 목록에 포함된 모든 사용자들에게 알림을 보낸다.