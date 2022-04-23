public class CreateCard {


    public static Card createCard(String cardType) throws Exception {

        Card card;
        if (cardType.equalsIgnoreCase("Credit")) {
            card = new CreditCard();

        } else if (cardType.equalsIgnoreCase("Debit")) {
            card = new DebitCard();

        } else {
            throw new Exception("Invalid Entry");
        }
        return card;
    }
}