# FileUploadDownload
파일 업로드 방법:
upload.jsp생성 및 렌더링 -> inputfile을 fileService를 통해서 비즈니스 로직 처리(DB에는 파일 정보 저장 및 로컬 PC에는 해당 파일 저장)

파일 다운로드 방법:
view.jsp생성 및 렌더링(파일 정보를 Model에 실어서 보냄) -> 파일들을 iterate하고, a태그를 통해서 링크를 건다 
-> 해당 링크로 이동하면, DB에서 파일 정보를 가져온 후 파일 다운로드 대화상자를 이용해서 파일을 다운로드 한다.

