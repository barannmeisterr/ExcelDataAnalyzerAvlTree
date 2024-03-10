//-----------------------------------------------------
// Title: Data Operations class
// Author: Arda Baran
// Description: This class defines operations of datas from excel file by using AVL Search Tree
//such as insert ,remove,search by full name ,get number of inserted records ,print tree ,traversals,
//calculates average grade of course etc.
//-----------------------------------------------------
public class DataOperations {
Student root;
public DataOperations() {
	this.root=null;
}
public int findMax(int a ,int b ) {
	return Math.max(a, b);
}
public int getHeight(Student node) {
	return (node==null) ? 0 : node.height;
}
public void updateHeight(Student node) {
	//--------------------------------------------------------
	// Summary: updates the height of node based on maximum of left and right + 1
	// Precondition: node is not null
	//--------------------------------------------------------
	int leftChild =getHeight(node.getLeft());
    int rightChild=getHeight(node.getRight());
    if (node != null) {
        node.height = findMax(leftChild, rightChild) + 1;
    }
}
public Student rightRotation(Student node) {
	//--------------------------------------------------------
	// Summary: node is rotated to right to fix left-left case
	// Precondition: node is not null and node has left child
	//--------------------------------------------------------
	if (node == null || node.getLeft() == null) {
        return node;
    }
	Student leftC=node.getLeft();
    node.setLeft(leftC.getRight());
    leftC.setRight(node);
    updateHeight(node);
    updateHeight(leftC);
    return leftC; 
}
public Student leftRotation(Student node) {
	//--------------------------------------------------------
	// Summary: node is rotated to left to fix right-right case
	// Precondition: node is not null and node has right child
	//--------------------------------------------------------
	if (node == null || node.getRight() == null) {
        return node;
    }
	Student rightC = node.getRight();
    node.setRight(rightC.getLeft());
    rightC.setLeft(node);

    updateHeight(node);
    updateHeight(rightC);
    return rightC; 
}
public int balanceFactor(Student node) {
	//--------------------------------------------------------
	// Summary: returns balance factor value if node is node null , else return 0
	// Precondition: node is not null to calculate height differences between left and right sides
	//--------------------------------------------------------
	return (node==null) ? 0 : getHeight(node.getLeft()) - getHeight(node.getRight()); 
}
public Student balance(Student node) {
    //--------------------------------------------------------
    // Summary: balances the tree based on names of students.
    // Rotations are applied if the tree is unbalanced.
    // Precondition: node is not null
    //--------------------------------------------------------
    if (node == null) {
        return null;
    }
    int comparisonLeft = compareStudents(node.getLeft(), node);
    int comparisonRight = compareStudents(node, node.getRight());
    int balanceFactor = balanceFactor(node);
    if (balanceFactor > 1) {
        // Left subtree is higher
        if (comparisonLeft >= 0) {
            // Left - Left case
            return rightRotation(node);
        } else {
            // Left - Right case
            node.setLeft(leftRotation(node.getLeft()));
            return rightRotation(node);
        }
    } else if (balanceFactor < -1) {
        // Right subtree is higher
        if (comparisonRight <= 0) {
            // Right - Right case
            return leftRotation(node);
        } else {
            // Right - Left case
            node.setRight(rightRotation(node.getRight()));
            return leftRotation(node);
        }
    }
    return node;
}
public int compareStudents(Student student1, Student student2) {
   
	//--------------------------------------------------------
	// Summary: Compares nameSurname of students without sensitivity
	//--------------------------------------------------------
		
	if(student1 == null || student2 == null) {
       //if both nodes are null,then return 0.
	   return 0;
    }
   
    return student1.getNameSurname().compareToIgnoreCase(student2.getNameSurname());
}
public Student insertRecord(Student node ,Student newNode) {
	//--------------------------------------------------------
		// Summary: insert tree records from xlsl excel file
		// Precondition: node is not null and there is no duplicate
		//--------------------------------------------------------
	if(node==null) {
		return new Student(newNode.getNameSurname(),newNode.getEmail(),newNode.getL1(),newNode.getL2(),newNode.getL3(),newNode.getL4(),newNode.getL5(),newNode.getPl6(),newNode.getL6(),newNode.getPl7(),newNode.getL7(),newNode.getPl8(),newNode.getL8(),newNode.getLabsOverall(),newNode.getProject(),newNode.getMidterm(),newNode.getFinAl(),newNode.getTotal());
	}
	if(newNode.getNameSurname().compareToIgnoreCase(node.getNameSurname()) < 0) {
	node.setLeft(insertRecord(node.getLeft(),newNode));
}else if(newNode.getNameSurname().compareToIgnoreCase(node.getNameSurname())> 0) {
	node.setRight(insertRecord(node.getRight(),newNode));
}
updateHeight(node);
return balance(node);
}
public boolean searchStudent(Student node,String key) {
	//--------------------------------------------------------
	// Summary: Controls key is present in tree
	// Precondition: node is not null and key is present in tree
	//--------------------------------------------------------
	if(node==null) {
		return false;
	}
	int nameSurnameComparison = key.compareToIgnoreCase(node.getNameSurname());
    
    if (nameSurnameComparison == 0 ) {
        return true;
    }
if(nameSurnameComparison < 0) {
	return searchStudent(node.getLeft(),key);
}else {
	return searchStudent(node.getRight(),key);
}
}
public void search(Student node,String key) {
	//--------------------------------------------------------
		// Summary: Searches the given key in the tree , if key is found then prints all informations about student 
		// Precondition: node is not null and key is present in tree
		//--------------------------------------------------------	
	if(node==null) {
		System.out.println("There is no record,database is empty.Please insert record first...");
		return ;
	}
	int nameSurnameComparison = key.compareToIgnoreCase(node.getNameSurname());
	if( nameSurnameComparison==0 && searchStudent(node,key)) {
        node.printStudent();
	}
	if(nameSurnameComparison<0&&searchStudent(node.getLeft(),key)) {
		search(node.getLeft(),key);
	} 
	if(nameSurnameComparison > 0 && searchStudent(node.getRight(),key)) {
		search(node.getRight(),key);
	}
	if(!searchStudent(node,key)&&!searchStudent(node.getLeft(),key)&&!searchStudent(node.getRight(),key)) {
		System.out.println(key+" Not Found In Records...");
	}
}
//prints all records in avl tree
public void printAllDatas(Student node) {
 
  if (node != null) {
      printStudentData(node);
      printAllDatas(node.getLeft());
      printAllDatas(node.getRight());
  }
}
public void printStudentData(Student student) {
  String data = String.format("%s,%s,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f,%.2f",
          student.getNameSurname(), student.getEmail(), student.getL1(), student.getL2(), student.getL3(),
          student.getL4(), student.getL5(), student.getPl6(), student.getL6(), student.getPl7(), student.getL7(),
          student.getPl8(), student.getL8(), student.getLabsOverall(), student.getProject(), student.getMidterm(),
          student.getFinAl(), student.getTotal());

  System.out.println(data);
}
public  void printTree(Student root) {
    printTree(root, 0);
}
public  void printTree(Student node, int depth) {
    if (node != null) {
        printTree(node.getRight(), depth + 1);

        for (int i = 0; i < depth; i++) {
            System.out.print("    ");
        }
        System.out.println(node.getNameSurname());

        printTree(node.getLeft(), depth + 1);
    }
} 
public Student getParentByName(Student root, String targetName) {
    if (root == null || targetName == null || targetName.isEmpty()) {
        return null; 
    }

   //if target name is found at left or right sides of root it means that root is parent so return root
    if ((root.getLeft() != null && root.getLeft().getNameSurname().equals(targetName)) ||
        (root.getRight() != null && root.getRight().getNameSurname().equals(targetName))) {
        return root;
    }
    // recursively controls left and right subtrees
    Student leftParent = getParentByName(root.getLeft(), targetName);
    if (leftParent != null) {
        return leftParent; // return parent found in left subtree
    }
    return getParentByName(root.getRight(), targetName); // return parent found in right subtree
}
public Student removeRecord(Student node,Student removedNode) {
	//--------------------------------------------------------
	// Summary: removes student.
	// Precondition:tree is not empty and desired node to remove is present at tree
	//--------------------------------------------------------
	if(node==null) {
		return null;
	}
	int comprasionResult =compareStudents(removedNode,node);
if(comprasionResult<0) {
	node.setLeft(removeRecord(node.getLeft(),removedNode));
}else if(comprasionResult>0) {
	node.setRight(removeRecord(node.getRight(),removedNode));
}else {
	//if node is leaf
	if(node.getLeft()==null&&node.getRight()==null) {
		node=null;
	return null;
	}
else if(node.getLeft()==null||node.getRight()==null) {
//if node is not leaf only has one child
	Student temp;
	if(node.getLeft()==null) {
		temp = node.getRight();
	}else {
		temp = node.getLeft();
	}
     node =null;
     return temp;
	//if node has left and right childs.	
}else {
	Student temp= findMinForRemoveRecord(node.getRight());
node.setNameSurname(temp.getNameSurname());
node.setRight(removeRecord(node.getRight(),temp));

}

}
updateHeight(node);
return balance(node);
}
public int getSize(Student node) {
	//--------------------------------------------------------
	// Summary: Number of students inserted to avl tree
	//--------------------------------------------------------
	if(node==null) {
		return 0;
	}
return getSize(node.getLeft())+getSize(node.getRight())+1;
}
public Student findMinForRemoveRecord(Student node) {
	//--------------------------------------------------------
		// Summary: removeRecord helper
		//--------------------------------------------------------
	
	if (node ==null) {
		return null;
	}
if(node.getLeft()==null) {
	return node;
}else {
	return findMinForRemoveRecord(node.getLeft());
}

}
//traversals
public void PreOrder(Student node) {
    if (node != null) {
        System.out.print(node.getNameSurname() + " ");
        PreOrder(node.getLeft());
        PreOrder(node.getRight());
    }
}
public void PostOrder(Student node) {
    if (node != null) {
        PostOrder(node.getLeft());
        PostOrder(node.getRight());
        System.out.print(node.getNameSurname() + " ");
    }
}

public void InOrder(Student node) {
    if (node != null) {
        InOrder(node.getLeft());
        System.out.print(node.getNameSurname() + " ");
        InOrder(node.getRight());
    }
}
public void InOrder() {
	System.out.print("In-Order Traversal: ");
	InOrder(root);
System.out.println();
}
public void PostOrder() {
	System.out.print("Post-Order Traversal: ");
	PostOrder(root);
System.out.println();
}
public void PreOrder() {
  
	System.out.print("Pre-Order Traversal: ");
	PreOrder(root);
System.out.println();
}
public double getSumOfOverallTotalGrade(Student node) {
	//--------------------------------------------------------
	// Summary: sum of all grades of the row named as 'total' in excel file
	//--------------------------------------------------------
	if(node==null) {
		return 0.0;
	}
double sum=0.0;
if(node!=null) {
	sum = node.getTotal();
}
sum+=getSumOfOverallTotalGrade(node.getLeft())+getSumOfOverallTotalGrade(node.getRight());
return sum;

}
public double average(Student node) {
	//--------------------------------------------------------
	// Summary: average of all grades of the row named as 'total' in excel file
    //--------------------------------------------------------	

	if(node==null) {
		return 0.0;
	}
return (getSumOfOverallTotalGrade(node) / getSize(node));

}
}
