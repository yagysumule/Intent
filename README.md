# Tujuan
_Codelab_ ini menitikberatkan pada implementasi intent untuk melakukan perpindahan dari activity ke activity lain, dengan atau tidak membawa data. Beberapa bagian dari _codelab_ ini akan menjawab beberapa pertanyaan umum dalam pengembangan aplikasi Android sebagai berikut:

* Bagaimana berpindah dari satu activity ke activity lain?
* Bagaimana berpindah dari satu activity ke activity lain dengan membawa data?
    * _Single value_ dari suatu variabel.
    * Objek model dengan menggunakan Parcelable.
* Menjalankan komponen di aplikasi lain untuk keperluan membuka _browser_ atau melakukan pemanggilan melalui aplikasi telepon bawaan?
* Mengirimkan hasil nilai balik melalui intent.

_Codelab_ selanjutnya adalah dengan membuat aplikasi yang dapat menerapkan kegunaan intent. Seperti ini tampilannya:

![Intent](https://user-images.githubusercontent.com/68750843/115341901-94b51980-a1d3-11eb-8914-1527c05e0f86.gif)

# Logika Dasar
__Berpindah__ dari suatu activity ke activity lain dengan membawa data. Activity asal akan __mengirimkan data__ melalui intent dan activity tujuan akan __menerima data__ yang dikirimkan.