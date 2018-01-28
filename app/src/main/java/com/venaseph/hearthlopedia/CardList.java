package com.venaseph.hearthlopedia;

import java.util.List;

/**
 * Created by cpera on 1/26/2018.
 */

public class CardList {

    public List<Card> Basic, Naxxramas;

    public List<Card> getCardList() {
        return Basic;
    }

    public void setCardList(List<Card> cardList) {
        this.Basic = Basic;
        this.Naxxramas = Naxxramas;
    }
}
