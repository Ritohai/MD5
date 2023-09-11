package ss7.th.service;

import ss7.th.model.Smartphone;

import java.util.List;
import java.util.Optional;

public interface ISmartphoneService {
    List<Smartphone> findAllByProducerContaining(String producer);
    List<Smartphone> findAll();
    Optional<Smartphone> findById(Long id);
    void deleteById(Long id);
    Smartphone save(Smartphone smartPhone);
}
