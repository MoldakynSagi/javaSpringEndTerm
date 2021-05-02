package kz.spring.endterm.controller;

import kz.spring.endterm.entity.Text;
import kz.spring.endterm.service.iservice.ITextService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/api/texts")
public class TextController {
    @Autowired
    private ITextService iTextService;

    // GET
    @GetMapping("")
    public ResponseEntity<?> getTextsByProductId(@RequestParam("musicId") Long musicId) {
        return ResponseEntity.ok(iTextService.getTextByProductId(musicId));
    }

    // POST
    @PostMapping("/create")
    public ResponseEntity<?> createNewText(@RequestBody Text text) {
        return ResponseEntity.ok(iTextService.createNew(text));
    }

    // PUT
    @PutMapping("/update")
    public ResponseEntity<?> updateText(@RequestBody Text text) {
        return ResponseEntity.ok(iTextService.updateText(text));
    }

    // DELETE
    @DeleteMapping("/delete/{id}")
    public void deleteText(@PathVariable("id") Long id) {
        iTextService.deleteTextById(id);
    }
}
