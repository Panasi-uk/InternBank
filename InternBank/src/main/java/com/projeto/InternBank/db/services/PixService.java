package com.projeto.InternBank.db.services;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.projeto.InternBank.db.models.Pix;
import com.projeto.InternBank.db.repositories.PixRepository;
import java.util.List;
import java.util.Optional;

@Service
public class PixService {

    @Autowired
    private PixRepository pixRepository;

    public List<Pix> getAllPix() {
        return pixRepository.findAll();
    }

    public Pix getPixById(Integer id) {
        Optional<Pix> pix = pixRepository.findById(id);
        return pix.orElse(null);
    }

    public Pix createPix(Pix pix) {
        return pixRepository.save(pix);
    }

    public Pix updatePix(Integer id, Pix pixAtualizado) {
        if (pixRepository.existsById(id)) {
            pixAtualizado.setPixId(id);
            return pixRepository.save(pixAtualizado);
        }
        return null;
    }

    public boolean deletePix(Integer id) {
        if (pixRepository.existsById(id)) {
            pixRepository.deleteById(id);
            return true;
        }
        return false;
    }
}
