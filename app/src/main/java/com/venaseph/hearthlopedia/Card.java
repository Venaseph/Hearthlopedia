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
    private Mechanics mechanics;

    public Card(){}

    public Card(String cardId, String name, String cardSet, String type, String faction, String rarity, String cost, String attack, String health, String text, String flavor, String artist, Boolean collectible, Boolean elite,
                String playerClass, String img, String imgGold, String locale, Mechanics mechanics) {
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

}

class Mechanics {

}




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