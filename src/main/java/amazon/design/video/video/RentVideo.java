package amazon.design.video.video;

import java.time.LocalDateTime;

public class RentVideo extends Video {

    private LocalDateTime rentFrom;
    private LocalDateTime rentTo;
    private LocalDateTime actualReturnTime;

    public LocalDateTime getRentFrom() {
        return rentFrom;
    }

    public void setRentFrom(LocalDateTime rentFrom) {
        this.rentFrom = rentFrom;
    }

    public LocalDateTime getRentTo() {
        return rentTo;
    }

    public void setRentTo(LocalDateTime rentTo) {
        this.rentTo = rentTo;
    }

    public LocalDateTime getActualReturnTime() {
        return actualReturnTime;
    }

    public void setActualReturnTime(LocalDateTime actualReturnTime) {
        this.actualReturnTime = actualReturnTime;
    }
}
