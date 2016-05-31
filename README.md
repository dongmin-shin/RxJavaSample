# RxJavaSample
This sample is RxJava essentials sample.

Chapter 8 변경 사항
- Retrofit1 -> Retrofit2 로 변경 됨
- Retrofit2에서 RxJava를 사용하기 위해서는 다음과 같은 작업이 필요하다.
- build.gradle에 compile 'com.squareup.retrofit:adapter-rxjava:2.x.x' 추가
- Retrofit retrofit = new Retrofit.Builder()<br/>
    .client(okHttpClient)<br/>
    .baseUrl(MovieDbApi.END_POINT)<br/>
    .addConverterFactory(GsonConverterFactory.create())<br/>
    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())<br/>
    .build();<br/>
