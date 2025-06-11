package cz.beavergame.MonsterBrew.service.impl;

import cz.beavergame.MonsterBrew.dto.MagicItemDto;
import cz.beavergame.MonsterBrew.entity.MagicItem.MagicItem;
import cz.beavergame.MonsterBrew.filter.MagicItemFilter;
import cz.beavergame.MonsterBrew.repository.MagicItem.MagicItemRepository;
import cz.beavergame.MonsterBrew.service.MagicItemService;
import cz.beavergame.MonsterBrew.specification.MagicItemSpecification;
import jakarta.persistence.EntityNotFoundException;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MagicItemServiceImpl implements MagicItemService {

    private final MagicItemRepository repository;

    public MagicItemServiceImpl(MagicItemRepository repository){
        this.repository = repository;
    }

    @Override
    public List<MagicItemDto> findAll() {
        return repository.findAll().stream().map(this::toDto).toList();
    }

    @Override
    public MagicItemDto findById(Long id) {
        return repository.findById(id)
                .map(this::toDto)
                .orElseThrow(() -> new EntityNotFoundException("MagicItem with ID " + id + " had not found."));
    }

    @Override
    public MagicItemDto create(MagicItemDto dto) {
        MagicItem item = fromDto(dto);
        return toDto(repository.save(item));
    }

    @Override
    public MagicItemDto edit(Long id, MagicItemDto dto) {

        MagicItem  actual = repository.findById(id).orElseThrow(() -> new RuntimeException("No item found"));

        actual.setName(dto.name());
        actual.setDescription(dto.description());
        actual.setType(dto.type());
        actual.setRarity(dto.rarity());
        actual.setRarityCustom(dto.rarityCustom());
        actual.setTypeCustom(dto.typeCustom());
        actual.setAttunement(dto.attunement());
        actual.setTags(dto.tags());
        actual.setPrice(dto.price());
        return null;
    }

    @Override
    public void delete(Long id) {
        repository.deleteById(id);
    }

    @Override
    public List<MagicItemDto> findByFilter(MagicItemFilter filter) {
        Specification<MagicItem> spec = MagicItemSpecification.haveName(filter.name())
                .and(MagicItemSpecification.haveAttunement(filter.attunement()))
                .and(MagicItemSpecification.haveRarity(filter.rarity()))
                .and(MagicItemSpecification.haveType(filter.type()));

        return repository.findAll(spec).stream().map(this::toDto).toList();
    }


    private MagicItemDto toDto(MagicItem p) {
        return new MagicItemDto(
                p.getId(),
                p.getName(),
                p.getDescription(),
                p.getRarity(),
                p.getRarityCustom(),
                p.getType(),
                p.getTypeCustom(),
                p.isAttunement(),
                p.getTags(),
                p.getPrice()
        );
    }

    private MagicItem fromDto(MagicItemDto dto) {
        MagicItem p = new MagicItem();

        p.setName(dto.name());
        p.setDescription(dto.description());
        p.setRarity(dto.rarity());
        p.setRarityCustom(dto.rarityCustom());
        p.setType(dto.type());
        p.setTypeCustom(dto.typeCustom());
        p.setAttunement(dto.attunement());
        p.setTags(dto.tags());
        p.setPrice(dto.price());
        return p;
    }
}
