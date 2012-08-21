/* Discounts the price of all music by the specified
 * composer, composer_in. The music is discounted by the
 * percentage specified by discount_in.
 *
 * Returns the number of rows modified, or -1 if the discount
 * value is invalid.
 *
 * Taken from Core Servlets and JavaServer Pages 2nd Edition
 * from Prentice Hall and Sun Microsystems Press,
 * http://www.coreservlets.com/.
 * &copy; 2003 Marty Hall and Larry Brown.
 * May be freely used or adapted.
 */

CREATE OR REPLACE FUNCTION discount
  (composer_in IN VARCHAR2, discount_in IN NUMBER)
RETURN NUMBER
IS
  min_discount CONSTANT NUMBER:= 0.05;
  max_discount CONSTANT NUMBER:= 0.50;
BEGIN
  IF discount_in BETWEEN min_discount AND max_discount THEN
    UPDATE music
    SET price = price * (1.0 - discount_in)
    WHERE composer = composer_in;
    RETURN(SQL%ROWCOUNT);
  ELSE
    RETURN(-1);
  END IF;
END discount;