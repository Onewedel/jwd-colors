package pl.edu.wszib.jwdcolors.dao;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;
import pl.edu.wszib.jwdcolors.model.SelectedColor;

import java.util.Collection;
import java.util.Collections;
import java.util.Date;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
class SelectedColorDaoTest {

    public static final String COLOR_BLUE = "blue";
    public static final String COLOR_RED = "red";
    public static final int TOTAL_COLORS = 3;

    @Autowired
    SelectedColorDao selectedColorDao;

    @BeforeEach
    void setUp() {
        SelectedColor selectedColor1 = new SelectedColor(COLOR_BLUE, new Date());
        SelectedColor selectedColor2 = new SelectedColor(COLOR_RED, new Date());
        SelectedColor selectedColor3 = new SelectedColor(COLOR_RED, new Date());

        assertNull(selectedColor1.getId());
        assertNull(selectedColor2.getId());
        assertNull(selectedColor3.getId());

        selectedColorDao.save(selectedColor1);
        selectedColorDao.save(selectedColor2);
        selectedColorDao.save(selectedColor3);

        assertNotNull(selectedColor1.getId());
        assertNotNull(selectedColor2.getId());
        assertNotNull(selectedColor3.getId());
    }

    @Test
    void testFetchData() {
        SelectedColor selectedColor = selectedColorDao.findFirstByColor(COLOR_RED);
        assertEquals(COLOR_RED, selectedColor.getColor(), "Znaleziono nieprawidłowy kolor");
    }
    @Test
    void testFetchAllData() {
        Collection selectedCollors = (Collection) selectedColorDao.findAll();
        assertEquals(TOTAL_COLORS, selectedCollors.size(), "Nieprawidłowa liczba kolorów,");
    }
}
