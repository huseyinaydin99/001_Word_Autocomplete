package tr.com.huseyinaydin.forms;

import java.util.List;
import javax.swing.ListModel;
import javax.swing.event.ListDataListener;

public class StringListModel implements ListModel<String>{

    private List<String> stringList;

    public StringListModel(List<String> stringList) {
        this.stringList = stringList;
    }
            
    @Override
    public int getSize() {
        return this.stringList.size();
    }

    @Override
    public String getElementAt(int index) {
        return this.stringList.get(index);
    }

    @Override
    public void addListDataListener(ListDataListener l) {
        
    }

    @Override
    public void removeListDataListener(ListDataListener l) {

    }    
}