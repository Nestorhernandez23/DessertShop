package DessertShop;

public interface Payable {
    enum PayType {
        CASH, CARD, PHONE
    }
    
    PayType getPayType();
    void setPayType(PayType payType);
}