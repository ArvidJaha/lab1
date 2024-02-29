public interface SubjectObserver {
    void addObserver(CarObserver observer);
    void removeObserver(CarObserver observer);
    void notifyObserver();
}
