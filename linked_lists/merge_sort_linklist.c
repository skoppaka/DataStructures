/*Merge Sort Linked List*/

#include <stdio.h>
#include <stdlib.h>

struct node* mergelist(struct node* a, struct node* b);
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
	struct node* head = *headref;
	if(head == NULL || head->next == NULL){
		return;
	}
	struct node* frontref;
	struct node* backref;
	splitlist(head, &frontref, &backref);

	sortlist(&frontref);
	sortlist(&backref);

	*headref = mergelist(frontref, backref);

}

struct node* mergelist(struct node* a, struct node* b){
	struct node* result = NULL;
	if(a == NULL){
		return b;
	}
	else if(b ==NULL){
		return a;
	}

	if(a->data <= b->data){
		result = a;
		result->next = mergelist(a->next, b);
	}
	else {
		result = b;
		result->next = mergelist(a, b->next);
	}
	
	return(result);
}

void splitlist(struct node* source, struct node** frontref, struct node** backref){
	int len = 0;
	int i = 0;
	struct node* current = source;
	while(current != NULL){
		len++;
		current = current->next;
	}
	current = source;
	if(len < 2){
		*frontref = source;
		*backref = NULL;
	}

	else {
		int jump = (len-1)/2;
		for(i = 0; i<jump;i++){
			current = current->next;
		}

		*frontref = source;
		*backref = current->next;
		current->next = NULL;
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
