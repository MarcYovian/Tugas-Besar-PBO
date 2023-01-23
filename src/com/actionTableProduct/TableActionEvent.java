package com.actionTableProduct;

import com.actionTableOwner.*;
import com.actionTableAdmin.*;

public interface TableActionEvent {
    
    public void onEdit(int row);
    
    public void onExited(int row);
    
}
