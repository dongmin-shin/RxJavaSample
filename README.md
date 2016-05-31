# RxJavaSample
This sample is RxJava essentials sample.

Chapter 8 변경 사항
- Retrofit1 -> Retrofit2 로 변경 됨
- Retrofit2에서 RxJava를 사용하기 위해서는 다음과 같은 작업이 필요하다.
- compile 'com.squareup.retrofit:adapter-rxjava:2.x.x'
- Retrofit retrofit = new Retrofit.Builder()
    .client(okHttpClient)
    .baseUrl(MovieDbApi.END_POINT)
    .addConverterFactory(GsonConverterFactory.create())
    .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
    .build();
