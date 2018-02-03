package com.venaseph.hearthlopedia;

import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by cpera on 1/26/2018.
 */

public class CardList {

    @SerializedName("Basic") public List<Card> Basic;
    @SerializedName("Classic") public List<Card> Classic;
    @SerializedName("Whispers of the Old Gods") public List<Card> Whispers;
    @SerializedName("One Night in Karazhan") public List<Card> Karazhan;
    @SerializedName("Mean Streets of Gadgetzan") public List<Card> MeanStreets;
    @SerializedName("Journey to Un'Goro") public List<Card> Ungoro;
    @SerializedName("Knights of the Frozen Throne") public List<Card> Knights;
    @SerializedName("Kobolds & Catacombs") public List<Card> Kolbolds;
    public ArrayList<Card> Standard;

    public void setCardList(List<Card> cardList) {
        this.Basic = Basic;
        this.Classic = Classic;
        this.Whispers = Whispers;
        this.Karazhan = Karazhan;
        this.MeanStreets = MeanStreets;
        this.Ungoro = Ungoro;
        this.Knights = Knights;
        this.Kolbolds = Kolbolds;
        this.Standard = Standard;
    }
}
