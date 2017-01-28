
package level;

import java.io.IOException;
import java.io.InputStream;

public interface LevelLoader {

	public Level loadLevel(InputStream input) throws IOException;
	
}

/**
 * א. ההפרדה בין יוצר המידע לבין מייצג המידע בוצעה באמצעות הפרדת ממשקים.יוצר המידע הוא הממשק LevelLoader ומייצג המידי הוא Level.
 * ב. העיקרון נשמר משום שהבנאי לא נמצא במחלקה המגדירה את האוייבייקט, אלא במחלקה המיועדת לטעון מקובץ.
 * ג. היא מאפשרת לשמור על העקרון בכך שבממשק מוגדרות הפונקציות שמופיעות במחלקות
 * ד. נשתמש בinputstream  נוכל לתמוך במערכות הפעלה מגוונות. בשימוש ב-string filename התמיכה מתבצעת בווינדוס בלבד 
 * @author Shelly Israeli and Benny Hayun
 *
 */