import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

public class Directory extends Entry{

	private final String m_name;
	private List<Entry> m_directory = new ArrayList<>();
	
	public Directory(final String name) {
		m_name = name;
	}
	@Override
	public String getName() {
		return m_name;
	}

	@Override
	public int getSize() {
		return m_directory.stream()
						  .collect(Collectors.summingInt(entry -> entry.getSize()));
	}

	@Override
	protected void printList(final String prefix) {
		System.out.println(prefix + "/" + this);	
		m_directory.stream()
				   .forEach(entry -> entry.printList(prefix + "/" + m_name));
	}
	
	//ディレクトリエントリをディレクトリに追加する
	public Entry add(final Entry entry) {
		m_directory.add(entry);
		return this;
	}

}
