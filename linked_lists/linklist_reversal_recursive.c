/*Linked List Reversal*/

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
	printf("List before reversal \n");
	printlist(headnode);
	reversal(&headnode);
	printf("List after reversal \n");
	printlist(headnode);

}

void reversal(struct node** headref){
	struct node* first;
	struct node* rest;

	if(*headref == NULL){
		return;
	}
	first = *headref;
	rest = first->next;

	if(rest == NULL){
		return;
	}

	reversal(&rest);
	first->next->next = first;
	first->next = NULL;
	
	*headref = rest;
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
