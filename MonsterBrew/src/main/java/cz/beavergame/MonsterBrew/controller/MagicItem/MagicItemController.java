package cz.beavergame.MonsterBrew.controller.MagicItem;

import cz.beavergame.MonsterBrew.dto.MagicItemDto;
import cz.beavergame.MonsterBrew.filter.MagicItemFilter;
import cz.beavergame.MonsterBrew.service.MagicItemService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/api/magic_items")
public class MagicItemController {

    private final MagicItemService service;

    public MagicItemController(MagicItemService service) {
        this.service = service;
    }
    @PostMapping
    public ResponseEntity<MagicItemDto> create(@RequestBody @Valid MagicItemDto dto) {
        return ResponseEntity.ok(service.create(dto));
    }
    @GetMapping
    public ResponseEntity<List<MagicItemDto>> findAll() {
        return ResponseEntity.ok(service.findAll());
    }
    @GetMapping("/{id}")
    public ResponseEntity<MagicItemDto> findById(@PathVariable Long id) {
        return ResponseEntity.ok(service.findById(id));
    }

    @PutMapping("/{id}")
    public ResponseEntity<MagicItemDto> edit(@PathVariable Long id, @RequestBody MagicItemDto dto) {
        return ResponseEntity.ok(service.edit(id, dto));
    }

    @DeleteMapping
    public ResponseEntity<Void> delete(@PathVariable Long id) {
        service.delete(id);
        return ResponseEntity.noContent().build();
    }

    @PostMapping("/filter")
    public ResponseEntity<List<MagicItemDto>> filter(@RequestBody MagicItemFilter filter) {
        return ResponseEntity.ok(service.findByFilter(filter));
    }


}
