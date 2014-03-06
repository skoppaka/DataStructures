/*Insertion Sort Linked List*/

#include <stdio.h>
#include <stdlib.h>

struct node{
	size_t data;
	struct node* next;
};
void main(int argc, char* argv[]){

	if(argc < 2){
		printf("Enter size of list \n");
		exit(0);
	}

	struct node* headnode;
	int i = 0;
	int list_size = atoi(argv[1]);
	
	for(i; i < list_size;i++){
		addnode(&headnode,(size_t)(rand()%list_size));
	}
	printf("List before sorting \n");
	printlist(headnode);
	sortlist(&headnode);
	printf("List after sorting \n");
	printlist(headnode);

}

void sortlist(struct node** headref){
	struct node* current = *headref;
	current = *headref;
	if(current->next == NULL){
		return;
	}
	while(current->next != NULL){
		if(current->next->data < current->data){
			struct node* temp = current->next;
			current->next = current->next->next;
			insertnode(headref, temp);
			continue;
		}
		if(current->next != NULL){
			current = current->next;
		}
	}
}		

void insertnode(struct node** headref, struct node* newnode){
	if(*headref == NULL || (*headref)->data >= newnode->data){
		newnode->next = *headref;
		*headref = newnode;
	}

	else{
		struct node* current = *headref;
		while(current->next != NULL && current->next->data<newnode->data){
			current = current->next;
		}
		newnode->next = current->next;
		current->next = newnode;
	}
}

void addnode(struct node** headref,size_t data ){
	struct node* current = *headref;
	struct node* newnode = malloc(sizeof(struct node));
	newnode->data = data;
	newnode->next = NULL;

	if(current == NULL){
		*headref = newnode;
	}
	else{
		while(current->next != NULL){
			current = current->next;
		}
		current->next = newnode;
	}

}

void printlist(struct node* headnode){
	struct node* current = headnode;

	while(current != NULL){
		printf(" %d ",current->data);
		current = current->next;
	}
	printf(" \n");
}
