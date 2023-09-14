# FileUploadDownload
파일 업로드 방법:
upload.jsp생성 및 렌더링 -> inputfile을 fileService를 통해서 비즈니스 로직 처리(DB에는 파일 정보 저장 및 로컬 PC에는 해당 파일 저장)

파일 다운로드 방법:
view.jsp생성 및 렌더링(파일 정보를 Model에 실어서 보냄) -> 파일들을 iterate하고, a태그를 통해서 링크를 건다 
-> 해당 링크로 이동하면, DB에서 파일 정보를 가져온 후 파일 다운로드 대화상자를 이용해서 파일을 다운로드 한다.

패치 1.
img 폴더를 static 하위에 추가. 왜냐하면 C드라이브 또는 다른 경로로 지정할 경우 접근이 절대 불가능, 막힘!!!
그래서 스프링부트 하위에 추가를 함.
그리고 이미지 업로드시 img폴더에 변경사항을 즉시 반영하기 위해서
Window -> Preferences -> General -> WorkSpace -> Refresh using native hooks and polling 체크
