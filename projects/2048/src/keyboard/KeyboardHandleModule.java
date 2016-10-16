package keyboard;

/**
 * Определяет параметры, которые игре необходимо считывать с клавиатуры.
 *
 * @author DoKel
 * @version 1.0
 */
public interface KeyboardHandleModule {

    /**
     * Считывание последних данных из стека событий, если можулю это необходимо
     */
    void update();

    /**
     * @return Возвращает направление последней нажатой "стрелочки",
     * либо AWAITING, если не было нажато ни одной
     */
    main.Direction lastDirectionKeyPressed();

    /**
     * @return Возвращает информацию о том, был ли нажат ESCAPE за последнюю итерацию
     */
    boolean wasEscPressed();

}