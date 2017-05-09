package ru.kpfu.itis.service;

import org.springframework.stereotype.Service;
import ru.kpfu.itis.form.AddQuantityForm;
import ru.kpfu.itis.form.AddStocktakingForm;
import ru.kpfu.itis.model.Stocktaking;

import java.util.List;

@Service
public interface StocktakingService {

    List<Stocktaking> getAll();
    Stocktaking getById(long id);
    List<Stocktaking> getAllByWarehouseId(long id);
    int getAllQuantityOnWarehouse(List<Stocktaking> stocktaking);
    List<Long> getIdsProducts(List<Stocktaking> stocktaking);
    void save(AddStocktakingForm form);
    void putQuantity(AddQuantityForm form);
    void delete(long id);
}
