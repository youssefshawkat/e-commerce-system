package system;
import java.time.LocalDate;

public interface Expirable {
    LocalDate getExpirationDate();

    void setExpirationDate(LocalDate expirationDate);

    public Boolean isExpired();

}
