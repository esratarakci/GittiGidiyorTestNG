# GittiGidiyorTestNG

username, password, environment, searchValue değerleri test başlamadan opsiyonel olarak değiştirilebilmektedir.

Proje altyapısı paralel koşuma uygun olarak hazırlanmıştır.

TestNG,POM, Maven, Log4j, AssertJUnit kullanılmıştır.

Sırasıyla;
- www.gittigidiyor.com sitesi açılır.
- Ana sayfanın açıldığı kontrol edilir. Siteye login olunur
- Login işlemi kontrol edilir.
- Arama kutucuğuna bilgisayar kelimesi girilir.
- Arama sonuçları sayfasından 2.sayfa açılır.
- 2.sayfanın açıldığı kontrol edilir.
- Sonuca göre sergilenen ürünlerden rastgele bir ürün seçilir.
- Seçilen ürün sepete eklenir.
- Ürün sayfasındaki fiyat ile sepette yer alan ürün fiyatının doğruluğu karşılaştırılır.
- Adet arttırılarak ürün adedinin 2 olduğu doğrulanır.
- Ürün sepetten silinerek sepetin boş olduğu kontrol edilir.

![Screenshot (373)](https://user-images.githubusercontent.com/37235504/106371588-32d4d880-6377-11eb-950d-14c53aa23c2e.png)
