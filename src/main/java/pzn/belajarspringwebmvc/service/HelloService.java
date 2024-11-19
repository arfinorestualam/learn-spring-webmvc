package pzn.belajarspringwebmvc.service;

public interface HelloService {

    String hello(String name);
}

//menggunakan interface agar nantinya ini di pakai ke class, classnya nanti menjadi bean
//ketika menjadi bean dan ingin di ubah, kita hanya mengubah class saja, jadi interfacenya
//tidak akan berubah, mengikuti banyaknya class yang memakai untuk diimplementasikan.
