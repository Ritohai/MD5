package ra.ss5spingboot.service;

public interface IGenericMapper <T,K,V>{
    T toEntity(K k);
    V toResponse(T t);

}
