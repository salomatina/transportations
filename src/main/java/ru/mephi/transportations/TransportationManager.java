package ru.mephi.transportations;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.mephi.transportations.entities.Manager;

@Service
public class TransportationManager {
    @Autowired
    private Manager manager;

    public int run() {
        return manager.orderToTransport();
    }

}
