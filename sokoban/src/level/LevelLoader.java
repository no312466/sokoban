
package level;

import java.io.IOException;
import java.io.InputStream;

public interface LevelLoader {

	public Level loadLevel(InputStream input) throws IOException;
	
}

/**
 * �. ������ ��� ���� ����� ���� ����� ����� ����� ������� ����� ������.���� ����� ��� ����� LevelLoader ������ ����� ��� Level.
 * �. ������� ���� ���� ������ �� ���� ������ ������� �� ����������, ��� ������ ������� ����� �����.
 * �. ��� ������ ����� �� ������ ��� ������ ������� ��������� �������� �������
 * �. ����� �inputstream  ���� ����� ������� ����� �������. ������ �-string filename ������ ������ �������� ���� 
 * @author Shelly Israeli and Benny Hayun
 *
 */