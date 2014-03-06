/*Sorting Arrays Using Binary Trees*/

#include <stdio.h>
#include <stdlib.h>

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
	for(i; i < list_size;i++){
		arr[i] = rand()%list_size;
		insertnode(&rootnode,(size_t)arr[i]);
	}
	printf("List before sorting \n");
	for(i=0;i<list_size;i++){
		printf(" %d ",arr[i]);
	}
	printf("\n");
	printf("List after sorting using inorder binary tree \n");
	inorder(rootnode);
	printf("\n");
	printf("List after sorting using preorder binary tree \n");
	preorder(rootnode);
	printf("\n");
	printf("List after sorting using postorder binary tree \n");
	postorder(rootnode);
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

void inorder(struct btreenode* bnode){
	if(bnode != NULL){
		inorder(bnode->leftchild);
		printf(" %d ",bnode->data);
		inorder(bnode->rightchild);
	}
	else
		return;
} 
void preorder(struct btreenode* bnode){
	if(bnode != NULL){
		printf(" %d ",bnode->data);
		preorder(bnode->leftchild);
		preorder(bnode->rightchild);
	}
	else
		return;
} 
void postorder(struct btreenode* bnode){
	if(bnode != NULL){
		postorder(bnode->leftchild);
		postorder(bnode->rightchild);
		printf(" %d ",bnode->data);
	}
	else
		return;
} 
