package pl.edu.wszib.jwdcolors.service;

import pl.edu.wszib.jwdcolors.model.SelectedColor;

import java.util.List;

public interface SelectedColorService {
    void save (String color);
    void save (SelectedColor selectedColor);
    List<SelectedColor> getAllData();


}
