package graphics;

import main.GameField;

/**
 * Определяет действия, которые должен производить графический модуль игры.
 *
 * @author DoKel
 * @version 1.0
 */
public interface GraphicsModule {

    /**
     * Отрисовывает переданное игровое поле
     *
     * @param field Игровое поле, которое необходимо отрисовать
     */
    void draw(GameField field);

    /**
     * @return Возвращает true, если в окне нажат "крестик"
     */
    boolean isCloseRequested();

    /**
     * Заключительные действия, на случай, если модулю нужно подчистить за собой.
     */
    void destroy();
}