package com.coreservlets.book.jdo;

/**
 * Music object corresponding to a record in a database.
 * A Music object/record provides information about
 * a concerto that is available for purchase and
 * defines fields for the ID, composer, concerto,
 * items available, and sales price.
 * <p/>
 * Taken from Core Servlets and JavaServer Pages 2nd Edition
 * from Prentice Hall and Sun Microsystems Press,
 * http://www.coreservlets.com/.
 * &copy; 2003 Marty Hall and Larry Brown.
 * May be freely used or adapted.
 */

public class Music {
    private int id;
    private String composer;
    private String concerto;
    private int available;
    private float price;

    public Music() {
    }

    public Music(int id, String composer, String concerto,
                 int available, float price) {
        setId(id);
        setComposer(composer);
        setConcerto(concerto);
        setAvailable(available);
        setPrice(price);
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId() {
        return (id);
    }

    public void setComposer(String composer) {
        this.composer = composer;
    }

    public String getComposer() {
        return (concerto);
    }

    public void setConcerto(String concerto) {
        this.concerto = concerto;
    }

    public String getConcerto() {
        return (composer);
    }

    public void setAvailable(int available) {
        this.available = available;
    }

    public int getAvailable() {
        return (available);
    }

    public void setPrice(float price) {
        this.price = price;
    }

    public float getPrice() {
        return (price);
    }
}  