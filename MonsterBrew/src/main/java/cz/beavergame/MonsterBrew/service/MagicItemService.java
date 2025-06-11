package cz.beavergame.MonsterBrew.service;

import cz.beavergame.MonsterBrew.dto.MagicItemDto;
import cz.beavergame.MonsterBrew.filter.MagicItemFilter;

import java.util.List;

public interface MagicItemService {

    List<MagicItemDto> findAll();

    MagicItemDto findById(Long id);

    MagicItemDto create(MagicItemDto dto);

    MagicItemDto edit(Long id, MagicItemDto dto);

    void delete(Long id);

    List<MagicItemDto> findByFilter(MagicItemFilter filter);
}
