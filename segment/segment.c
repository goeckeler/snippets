#include <stdio.h>
#include <string.h>
#include <stdlib.h>
#include <math.h>

// number of dots needed from top to bottom row
const int dots = 5;

// digits as segments using ASCII box-drawing chars
const char* segments[10][5] = {
    // 0
    {"┌─┐",
     "│ │",
     "│ │",
     "│ │",
     "└─┘"},
    // 1
    {"  ┐",
     "  │",
     "  │",
     "  │",
     "  ┴"},
    // 2
    {"┌─┐",
     "  │",
     "┌─┘",
     "│  ",
     "└─┘"},
    // 3
    {"┌─┐",
     "  │",
     " ─┤",
     "  │",
     "└─┘"},
    // 4
    {"│  ",
     "│ │",
     "└─┤",
     "  │",
     "  ┴"},
    // 5
    {"┌─┐",
     "│  ",
     "└─┐",
     "  │",
     "└─┘"},
    // 6
    {"┌─┐",
     "│  ",
     "├─┐",
     "│ │",
     "└─┘"},
    // 7
    {"┌─┐",
     "  │",
     "  │",
     "  │",
     "  │"},
    // 8
    {"┌─┐",
     "│ │",
     "├─┤",
     "│ │",
     "└─┘"},
    // 9
    {"┌─┐",
     "│ │",
     "└─┤",
     "  │",
     "└─┘"}
};

// minus sign
const char* minus_sign[5] = {
    "   ",
    "   ",
    "───",
    "   ",
    "   "
};

void print_number(long long integer) {
    // take care of negative numbers
    int is_negative = 0;
    if (integer < 0) {
        is_negative = 1;
        integer = -integer;
    }

    long digits = (integer == 0 ? 1 : ceil(log10(llabs(integer))));
    char number[digits];
    int length = 0;

    // we will scan the complete number and then print it row by row, thus we need a stringified version of the integer
    sprintf(number, "%lld", integer);
    length = strlen(number);

    // we will print row by row
    for (int row = 0; row < dots; ++row) {
        // prepend with minus sign if necessary
        if (is_negative) {
            printf(" %s ", minus_sign[row]);
        }

        // now print the corresponding line of each digit
        for (int i = 0; i < length; ++i) {
            int digit = number[i] - '0';
            printf(" %s ", segments[digit][row]);
        }

        // next line
        printf("\n");
    }
}

int main() {
    long long number;

    printf("Gib eine Ganzzahl ein: ");

    if (scanf("%lld", &number) != 1) {
        printf("Fehler: Keine gültige Ganzzahl eingegeben!\n");
        return 1;
    }

    printf("\n7-Segment-Anzeige:\n\n");
    print_number(number);

    return 0;
}
