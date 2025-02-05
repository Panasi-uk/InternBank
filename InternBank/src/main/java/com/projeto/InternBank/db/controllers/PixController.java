package com.projeto.InternBank.db.controllers;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import com.projeto.InternBank.db.models.Pix;
import com.projeto.InternBank.db.services.PixService;
import java.util.List;

@RestController
@RequestMapping("/api/pix")
public class PixController {

    @Autowired
    private PixService pixService;

    @GetMapping
    public ResponseEntity<List<Pix>> getAllPix() {
        List<Pix> pix = pixService.getAllPix();
        return ResponseEntity.ok(pix);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Pix> getPixById(@PathVariable Integer id) {
        Pix pix = pixService.getPixById(id);
        return (pix != null) ? ResponseEntity.ok(pix) : ResponseEntity.notFound().build();
    }

    @PostMapping
    public ResponseEntity<Pix> createPix(@RequestBody Pix pix) {
        Pix novoPix = pixService.createPix(pix);
        return ResponseEntity.ok(novoPix);
    }

    @PutMapping("/{id}")
    public ResponseEntity<Pix> updatePix(@PathVariable Integer id, @RequestBody Pix pix) {
        Pix pixAtualizado = pixService.updatePix(id, pix);
        return (pixAtualizado != null) ? ResponseEntity.ok(pixAtualizado) : ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletePix(@PathVariable Integer id) {
        if (pixService.deletePix(id)) {
            return ResponseEntity.noContent().build();
        }
        return ResponseEntity.notFound().build();
    }
}
