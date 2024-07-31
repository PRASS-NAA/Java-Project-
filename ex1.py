import pandas as pd
import seaborn as sb
import matplotlib.pyplot as plt 

file = sb.load_dataset('titanic')

print(file.isnull().sum())
file['age'] = file['age'].fillna(file['age'].median())
# inter quartile method

def remove_outliers(df,column):
    q1 = df[column].quantile(0.25)
    q2 = df[column].quantile(0.75)
    iqr = q2 -q1
    lower_bound = q1 - 1.5 * iqr
    upper_bound = q2 + 1.5 * iqr
    return df[(df[column] >= lower_bound) & (df[column] <= upper_bound)]

file_cleaned = remove_outliers(file,'age')
file_cleaned = remove_outliers(file_cleaned,'fare')

print(file_cleaned.describe())
#histogram for fare
plt.figure(figsize=(10,5))
plt.subplot(1,2,2)
plt.hist(file_cleaned['fare'], bins =20 , edgecolor ='k' )
plt.title('fare distribution')
plt.xlabel('fare')
plt.ylabel('freequency')
#histogram for age
plt.figure(figsize=(10,5))
plt.subplot(1,2,2)
plt.hist(file_cleaned['age'], bins =20 , edgecolor ='k' )
plt.title('age distribution')
plt.xlabel('age')
plt.ylabel('freequency')

    



