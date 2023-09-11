<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<html>
<head>
    <title>회원가입 폼</title>
    <link rel="stylesheet" href="resources/css/testjoin.css">
    <script src="https://code.jquery.com/jquery-latest.js"></script>
</head>
<script>
    $(document).ready(function() {
        
        //ID 중복검사
        let idcheck_value='';
        $('#idcheck').click(function() {
            const id = $('#id');

            // 제이쿼리에서 제공하는 trim()을 이용해서 공백을 제거합니다.
            // 사용법) $.trim(str);
            // str의 앞뒤 공백을 제거합니다.
            const id_value = $.trim(id.val());
            if(id_value == ""){
                alert("ID를 입력 하세요");
                id.focus();
                return false;
            }
                // 첫글자는 대문자이고 두번째부터는 대소문자, 숫자, _로 총 4개 이상
                const pattern = /^[A-Z][A-Za-z0-9_]{3,}$/;
                if (pattern.test(id_value)){
                    idcheck_value = id_value;
//                    const ref = `idcheck.html?id=${id_value}`;
//                    window.open(ref, "idcheck", "width=350, height=200");
					alert("중복 검사 완료");
                } else {
                    alert("첫글자는 대문자이고 두번째부터는 대소문자, 숫자, _로 총 4개 이상이어야 합니다.");
                    id.val('').focus();
                }
            

        });// $('#idcheck').click(function() end

        
        //공백 유효성 검사
        $('form').submit(function (){
            // 제이쿼리에서 제공하는 trim()을 이용해서 공백을 제거합니다.
            // 사용법) $.trim(str); - str의 앞뒤 공백을 제거합니다.
            const id = $('#id');
            if($.trim(id.val()) == ""){
                alert("ID를 입력하세요");
                id.focus();
                return false;
            }

            //submit할때의 id값과 ID중복검사때 사용한 id가 다른 경우 메시지 출력합니다.
            let submit_id_value = $.trim(id.val())
            if(submit_id_value != idcheck_value){
                alert("ID 중복검사를 하세요");
                return false;
            }

            const pass = $("#pass");
            if($.trim(pass.val()) == ""){
                alert("비밀번호를 입력 하세요");
                pass.focus();
                return false;
            }

            const jumin1= $('#jumin1');
            if($.trim(jumin1.val()) == ""){
                alert("주민번호 앞자리를 입력하세요");
                jumin1.focus();
                return false;
                }

            if ($.trim(jumin1.val()).length != 6) {
                alert("주민번호 앞자리 6자리를 입력하세요");
                jumin1.val("").focus();
                return false;
                }

            const jumin2= $('#jumin2');
                if($.trim(jumin2.val()) == ""){
                alert("주민번호 뒷자리를 입력하세요");
                jumin2.focus();
                return false;
                }
            if ($.trim(jumin2.val()).length != 7) {
                alert("주민번호 뒷자리 7자리를 입력하세요");
                jumin2.val("").focus();
                return false;
                }

            const email= $('#email');
                if($.trim(email.val()) == ""){
                alert("E-mail 아이디를 입력하세요");
                email.focus();
                return false;
                }

            const domain= $('#domain');
                if($.trim(domain.val()) == ""){
                alert("E-mail 도메인을 입력하세요");
                domain.focus();
                return false;
                }

            let gender = $('input[type=radio]:checked').length;
                if (gender == 0) {
                alert("성별을 선택하세요");
                return false;
                }

            let hobby = $('input[type=checkbox]:checked').length;
                if (hobby < 2) {
                alert("2개 이상의 취미를 선택하세요");
                return false;
                }

            let post1= $('#post1');
                if($.trim(post1.val()) == ""){
                alert("E-우편번호를 입력하세요");
                post1.focus();
                return false;
                }
            
            if(!$.isNumeric(post1.val())){
                alert("우편번호는 숫자만 입력 가능 합니다.");
                post1.val('').focus();
                return false;
            }

            const address= $('#address');
                if($.trim(address.val())==""){
                alert("주소를 입력하세요");
                address.focus();
                return false;
                }

            const intro= $('#intro');
                if($.trim(intro.val())==""){
                alert("자기 소개를 입력하세요");
                intro.focus();
                return false;
                }
        })

        //우편검색 버튼 클릭
        $('#postcode').click(function(){
//            window.open('post.html','post','width=400,height=500,scrollbars=yes');
			alert("(우편번호 입력 폼)우편 번호를 입력하세요");
        }); //$('#postcode').click(function() end

        //도메인 선택 부분
        $('#sel').change(function(){
            const domain = $('#domain');
            if($(this).val() == ''){
                domain.val('').focus().prop('readOnly', false);
            }else {
                domain.val($(this).val()).prop('readOnly',true);
            }
        }); //$('#sel').change(function() end
        
        $('#jumin1').keyup(function(){
            if($('#jumin1').val().length == 6){
                pattern = /^[0-9]{2}(0[1-9]|1[0-2])(0[1-9]|[12][0-9]|[3][01])$/;
                if(pattern.test($(this).val())){
                    $('#jumin2').focus();   // 주민번호 뒷자리로 포커스 이동
                }else {
                    alert("숫자 또는 형식에 맞게 입력하세요[yymmdd]");
                    $(this).val('').focus();
                }
            }
        })  //$('#jumin1').keyup(function() end

        $('#jumin2').keyup(function() {
            if($.trim($(this).val()).length == 7){
                pattern = /^[1234][0-9]{6}$/;
                if(pattern.test($(this).val())){
                    const c = $(this).val().substring(0, 1);
                    const index = (c - 1) % 2;  //c=1,3이면 index=0 , c=2,4이면 index=1
                    
                    $('input[type=radio]').eq(index).prop('checked', true);
                } else {
                    alert("형식에 맞게 입력하세요[1234][0-9]{6}");
                    $(this).val('').focus();
                }
            }
        })  //$('#jumin2').keyup(function() end

});
</script>
<body>
    <div class="container">
        <form name="myform" method="post" action="joinProcess" id="myform">
            <fieldset>

                <!-- legend 유효성 검사 -->
                <legend>유효성 검사</legend>

                <!-- ID -->
                <label for="id">ID</label>
                <div>
                    <input type="text" size="10" name="id" id="id">
                    <input type="button" value="ID중복검사" id="idcheck">
                </div>

                <!-- Pass -->
                <label for="pass">Password</label>
                <input type="password" placeholder="enter password" name="pass" id="pass">

                <!-- jumin1 -->
                <label for="jumin1">주민번호</label>
                <input type="text" placeholder="주민번호 앞자리" size="6" maxlength="6" name="jumin1" id="jumin1">
                <b>-</b>
                <input type="text" placeholder="주민번호 뒷자리" size="7" maxlength="7" name="jumin2" id="jumin2">

                <!-- email -->
                <label for="email">E-Mail</label>
                <input type="text" name="email" id="email">
                @
                <input type="text" name="domain" id="domain">

                <!-- domain1 -->
                <select name="sel" id="sel">
                    <option value="">직접입력</option>
                    <option value="naver.com">naver.com</option>
                    <option value="daum.net">daum.net</option>
                    <option value="nate.com">nate.com</option>
                    <option value="gmail.com">gmail.com</option>
                </select>

                <!-- gender -->
                <label>성별</label>
                <div class="container2">
                    <!-- type = "radio"는 readOnly가 작동하지 않아 ojnclick = "Return false"로 해결합니다. -->
                    <input type="radio" name="gender" value="m" id="gender1">남자
                    <input type="radio" name="gender" value="f" id="gender2">여자
                </div>

                <!-- hobby -->
                <label>취미</label>
                <input type="checkbox" name="hobby" id="hobby1" value="공부">공부
                <input type="checkbox" name="hobby" id="hobby2" value="게임">게임
                <input type="checkbox" name="hobby" id="hobby3" value="운동">운동
                <input type="checkbox" name="hobby" id="hobby4" value="등산">등산
                <input type="checkbox" name="hobby" id="hobby5" value="낚시">낚시

                <!-- Post -->
                <label for="post1">우편번호</label>
                <input type="text" maxlength="5" name="post1" id="post1">
                <input type="button" value="우편검색" id="postcode">

                <!-- address -->
                <label for="address">주소</label>
                <input type="text" name="address" id="address">

                <!-- intro -->
                <label for="intro">자기소개</label>
                <textarea rows="10" cols="75" name="intro" id="intro"></textarea>

                <!-- button -->
                <div class="clearfix"></div>
                <button type="submit" class="signupbtn">회원가입</button>
                <button type="reset" class="cancelbtn">취소</button>

            </fieldset>
        </form>
    </div>
</body>
</html>
