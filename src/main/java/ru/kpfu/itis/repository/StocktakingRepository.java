package ru.kpfu.itis.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import ru.kpfu.itis.model.Stocktaking;

import java.util.List;

@Repository
public interface StocktakingRepository extends JpaRepository<Stocktaking, Long>{

    List<Stocktaking> findAll();
    Stocktaking findById(long id);
    List<Stocktaking> findAllByWarehouseId(long id);
}
