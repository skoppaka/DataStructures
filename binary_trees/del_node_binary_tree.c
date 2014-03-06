/*Sorting Arrays Using Binary Trees*/

#include <stdio.h>
#include <stdlib.h>
typedef int bool;
#define true 1
#define false 0
struct btreenode{
	struct btreenode* leftchild;
	size_t data;
	struct btreenode* rightchild;
};
void main(int argc, char* argv[]){

	if(argc < 2){
		printf("Enter size of list \n");
		exit(0);
	}

	struct btreenode* rootnode = NULL;
	int i = 0;
	int list_size = atoi(argv[1]);
	int arr[list_size];
	int num;
	for(i; i < list_size;i++){
		arr[i] = rand()%list_size;
		insertnode(&rootnode,(size_t)arr[i]);
	}

	printf("Enter node to be deleted \n");
	scanf("%d",&num);
	printf("List before deleting node \n");
	for(i=0;i<list_size;i++){
		printf(" %d ",arr[i]);
	}
	printf("\n");
	delete_node(&rootnode,(size_t)num);
	printf("List after deleting node in tree\n");
	if(rootnode != NULL){
		inorder(rootnode);
	}
	printf("\n");
}

void insertnode(struct btreenode** noderef,size_t data ){
	struct btreenode* current = NULL;
	if(*noderef == NULL){
		*noderef =  (struct btreenode*)malloc(sizeof(struct btreenode));
		(*noderef)->leftchild = NULL;
		(*noderef)->data = data;
		(*noderef)->rightchild = NULL;
		return;
	}
	
	else{
		if((*noderef)->data > data){
			insertnode(&((*noderef)->leftchild),data);
		}
		else{
			insertnode(&((*noderef)->rightchild),data);
		}
	}
	return;

}


void delete_node(struct btreenode** noderef, size_t num){
	struct btreenode* del_par;
	struct btreenode* del;
	struct btreenode* del_succ;
	struct btreenode* del_succ_par;
	bool found;

	if(*noderef == NULL){
		printf("Tree empty \n");
		return;
	}
	search_node(noderef, &del, &del_par,num, &found);
	if(found == false){
		printf("Data not found in tree \n");
		return;
	}
	
	if(del->leftchild == NULL && del->rightchild == NULL){
		if(del == *noderef){
			free(del);
			printf("Deleted node, tree empty now \n");
			return;
		}
		if(del_par->leftchild == del){
			del_par->leftchild = NULL;
		}
		else{
			del_par->rightchild = NULL;
		}
		free(del);
		return;
	}
	
	if(del->leftchild != NULL && del->rightchild == NULL){
		if(del == *noderef){
			*noderef = del->leftchild;
			free(del);
			return;
		}
		if(del_par->leftchild == del){
			del_par->leftchild = del->leftchild;
		}
		else{
			del_par->rightchild = del->leftchild;
		}
		free(del);
		return;	
	}
		
	if(del->leftchild == NULL && del->rightchild != NULL){
		if(del == *noderef){
			*noderef = del->rightchild;
			free(del);
			return;
		}
		if(del_par->leftchild == del){
			del_par->leftchild = del->rightchild;
		}
		else{
			del_par->rightchild = del->rightchild;
		}
		free(del);
		return;	
				
	}

	if(del->leftchild != NULL && del->rightchild != NULL){
		del_succ = del->rightchild;
		del_succ_par = del;

		while(del_succ->leftchild != NULL){
			del_succ_par = del_succ;
			del_succ = del_succ->leftchild;
		}

		if(del_succ_par == del){
			if(del == *noderef){
				*noderef = del_succ;
				del_succ->leftchild = del->leftchild;
				free(del);
				return;
			}
			if(del_par->leftchild == del){
				del_par->leftchild = del_succ;
			}
			else{
				del_par->rightchild = del_succ;
			}
			del_succ->leftchild = del->leftchild;
			free(del);
			return;
		}
		if(del == *noderef){
			*noderef = del_succ;
		}else{
			if(del_par->leftchild == del){
				del_par->leftchild = del_succ;
			}
			else{
				del_par->rightchild = del_succ;
			}
		}
		del_succ_par->leftchild = del_succ->rightchild;
		del_succ->leftchild = del->leftchild;
		del_succ->rightchild = del->rightchild;
		
		free(del);
		return;
	}
}
void search_node(struct btreenode** noderef, struct btreenode** del, struct btreenode** del_par, int num, bool* found){
	struct btreenode* current = *noderef;
	*found = false;
	*del_par = NULL;
	while(current != NULL){
		if(current->data == num){
			*found = true;
			*del = current;
			return;
		}
			
		*del_par = current;
		if(current->data > num){
			current = current->leftchild;
		}
		else {
			current = current->rightchild;
		}
	}
}

void inorder(struct btreenode* bnode){
	if(bnode != NULL){
		inorder(bnode->leftchild);
		printf(" %d ",bnode->data);
		inorder(bnode->rightchild);
	}
	else
		return;
} 
