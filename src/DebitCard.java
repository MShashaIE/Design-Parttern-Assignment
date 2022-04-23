public class DebitCard extends Card {
    private static boolean instance_flag = false;

    public DebitCard() throws CustomException {

        if (instance_flag) {
            throw new CustomException();
        } else instance_flag = true;

    }

    @Override
    public String getCardType() {
        return "Debit Card";
    }

}