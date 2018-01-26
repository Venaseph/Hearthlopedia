package com.venaseph.hearthlopedia;

/**
 * Created by Chris on 1/26/2018.
 */
public class Card {
    private String cardId;
    private String name;
    private String cardSet;
    private String type;
    private String faction;
    private String rarity;
    private String cost;
    private String attack;
    private String health;
    private String text;
    private String flavor;
    private String artist;
    private Boolean collectible;
    private Boolean elite;
    private String playerClass;
    private String img;
    private String imgGold;
    private String locale;

    public Card(){}

    public Card(String cardId, String name, String cardSet, String type, String faction, String rarity, String cost, String attack, String health, String text, String flavor, String artist, Boolean collectible, Boolean elite,
                String playerClass, String img, String imgGold, String locale) {
        this.cardId = cardId;
        this.name = name;
        this.cardSet = cardSet;
        this.type = type;
        this.faction = faction;
        this.rarity = rarity;
        this.cost = cost;
        this.attack = attack;
        this.health = health;
        this.text = text;
        this.flavor = flavor;
        this.artist = artist;
        this.collectible = collectible;
        this.elite = elite;
        this.playerClass = playerClass;
        this.img = img;
        this.imgGold = imgGold;
        this.locale = locale;
    }

    public String getCardId() {
        return cardId;
    }

    public String getName() {
        return name;
    }

    public String getCardSet() {
        return cardSet;
    }

    public String getType() {
        return type;
    }

    public String getFaction() {
        return faction;
    }

    public String getRarity() {
        return rarity;
    }

    public String getCost() {
        return cost;
    }

    public String getAttack() {
        return attack;
    }

    public String getHealth() {
        return health;
    }

    public String getText() {
        return text;
    }

    public String getFlavor() {
        return flavor;
    }

    public String getArtist() {
        return artist;
    }

    public Boolean getCollectible() {
        return collectible;
    }

    public Boolean getElite() {
        return elite;
    }

    public String getPlayerClass() {
        return playerClass;
    }

    public String getImg() {
        return img;
    }

    public String getImgGold() {
        return imgGold;
    }

    public String getLocale() {
        return locale;
    }

}
// Sample API pull
//								[
//                                        {
//                                        "cardId": "EX1_116",
//                                        "dbfId": "559",
//                                        "name": "Leeroy Jenkins",
//                                        "cardSet": "Classic",
//                                        "type": "Minion",
//                                        "faction": "Alliance",
//                                        "rarity": "Legendary",
//                                        "cost": 5,
//                                        "attack": 6,
//                                        "health": 2,
//                                        "text": "<b>Charge</b>. <b>Battlecry:</b> Summon two 1/1 Whelps for your opponent.",
//                                        "flavor": "At least he has Angry Chicken.",
//                                        "artist": "Gabe from Penny Arcade",
//                                        "collectible": true,
//                                        "elite": true,
//                                        "playerClass": "Neutral",
//                                        "img": "http://media.services.zam.com/v1/media/byName/hs/cards/enus/EX1_116.png",
//                                        "imgGold": "http://media.services.zam.com/v1/media/byName/hs/cards/enus/animated/EX1_116_premium.gif",
//                                        "locale": "enUS",
//                                        "mechanics": [
//                                        {
//                                        "name": "Charge"
//                                        },
//                                        {
//                                        "name": "Battlecry"
//                                        }
//                                        ]
//                                        }
//                                        ]