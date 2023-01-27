# Team2_backend   

### 신학기가 시작되자 긍정 에너지가 필요한 토끼는 긍정적인 삶을 위한 여정을 떠난다.  
토끼가 역경과 고난을 견디고 일어나 긍정적인 삶을 위한 여정을 떠나는 게임  
랭킹 페이지에서는 플레이 점수를 기반으로 서로에게 덕담(긍정적인 에너지)을 전달 가능  
![image](https://user-images.githubusercontent.com/107793780/215162774-be3dcc0a-e76a-468a-8395-beb54faf22f1.png)


### ERD
![image](https://user-images.githubusercontent.com/107793780/215160655-2d8a1a6d-d786-443d-96cf-25c5eca405b2.png)

### API
GetMapping("/") : 메인 페이지  
PostMapping("/") : 로그인 시도   
GetMapping("/game") : 게임 페이지  
GetMapping("/rank") : 순위 페이지 + 덕담  
GetMapping ("/score") : 현재 멤버의 기존 점수 및 덕담  
PatchMapping ("/score") : 해당 멤버의 기록 업데이트   
